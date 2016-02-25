



import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class logicServ {
	private static ConfigurableApplicationContext ctx;
	private static Logger logger=Logger.getLogger(logicServ.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length==0){
			System.out.print("error,not port");
			return;
		}
		System.setProperty("port", args[0]);
		int core=Runtime.getRuntime().availableProcessors()+1;
		System.setProperty("coreCount", core+"");
//		PropertyConfigurator.configure(logicServ.class.getResource("log4j.properties"));
		ctx=new ClassPathXmlApplicationContext("server.xml");
		ctx.registerShutdownHook();
		logger.info("logic startup port:"+args[0]+",work pool size:"+core);
	}

}
