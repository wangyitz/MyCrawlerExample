package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */


public class pttexam {
	// commit test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481382833.A.7CE.html";

		//System.out.println(
				Document jsoup =CrawlerPack.start()
							    .addCookie("over18","1")	// 設定cookie
							    .getFromHtml(uri);

			    
			    // 這兒開始是 Jsoup Document 物件操作
			    //.select(" .push ")
				//.select(" span[class*='push']")
				//.select("span:containsOwn(推)+span")



				for(Element elem : jsoup.select("#main-content *")) {
						elem.remove();
				}
				System.out.println(jsoup.select("#main-content").text());
		}
		//);
	}

