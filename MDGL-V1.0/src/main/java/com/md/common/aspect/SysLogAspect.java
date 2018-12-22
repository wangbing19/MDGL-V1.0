package com.md.common.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.common.annotation.sys.RequiresLog;
import com.md.common.utils.IPUtils;
import com.md.common.utils.ShiroUtils;
import com.md.sys.dao.sys.SysLogDao;
import com.md.sys.entity.sys.SysLog;


/**
 * 使用@Aspect注解修饰的类为一个切面类型 切面对象：封装扩展功能 切面构成：
 * 1)切入点(Pointcut):切入扩展功能的点，连接点(一个具体方法)结合 2)通知(Advice) 本质为一个实现了扩展功能的一个方法
 */
@Aspect
@Service
public class SysLogAspect {
	public SysLogAspect() {
		System.out.println("SysLogAspect()");
	}

	@Autowired
	private SysLogDao sysLogDao;

	/**
	 * 1)@Pointcut 注解用于定义切入点 2)bean(...) 为一种切入点表达式(值为bean的id)
	 */
	@Pointcut("@annotation(com.md.common.annotation.sys.RequiresLog)")
	public void logPointCut() {
	}// 空方法(相当于为切入点起了个别名)

	/**
	 * 说明: 1)@Around 描述方法为一个环绕通知
	 * 
	 * @param jp 为一个连接点(切入点中的某个方法信息对象)
	 * @return 目标方法的执行结果
	 * @throws Throwable
	 */
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = jp.proceed();// 执行目标方法
		long end = System.currentTimeMillis();
		System.out.println("execute time :"+(end-start));
		saveObject(jp, end - start);
		return result;
	}

	private void saveObject(ProceedingJoinPoint jp, long totalTime) throws NoSuchMethodException, SecurityException {
		// 1.获取日志信息
		//String username = ShiroUtils.getUser().getUsername();
		String username="admin测试";
		String ip = IPUtils.getIpAddr();
		// 获取方法签名信息(包含了方法名以及参数列表信息)
		Signature s = jp.getSignature();
		// System.out.println(s.getClass().getName());
		MethodSignature ms = (MethodSignature) s;
		// 获取目标对象的类对象(字节码对象：反射的起点)
		Class<?> targetCls = jp.getTarget().getClass();
		// 获取目标方法对象
		Method targetMethod = targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
		// 获取目标方法上的RequiresLog注解
		RequiresLog requiresLog = targetMethod.getDeclaredAnnotation(RequiresLog.class);
		// 获取注解中value属性的值
		String operation = requiresLog.value();
		String method = targetCls.getName() + "." + targetMethod.getName();
		String params = Arrays.toString(jp.getArgs());
		// 2.封装日志信息(封装到SysLog对象)
		SysLog log = new SysLog();
		log.setUsername(username);
		log.setIp(ip);
		log.setOperation(operation);
		log.setMethod(method);
		log.setParams(params);
		log.setTime(totalTime);
		log.setCreatedTime(new Date());
		// 3.存储日志信息(写入到数据库)
		sysLogDao.insertObject(log);
	}
}
