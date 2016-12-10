package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.8"
				+ "/crazyck101/posts?fields=id,message,created_time,reactions.type(HAHA).limit(0).summary(total_count)&since=1480849200&until=1480856400"
				+ "&access_token=EAACEdEose0cBAHH4v0o4Tb0vg9aZCpSB0JYdfiysxDtcEldzVgSm2CdvsNrdaBJkYMHS10a6ec6taBZAqoBevdXIdO4vij7RwyoDPUvej5Ln8Ryxb9ZBQhNamWPrDksZCud6jYbTnbD20CCBu6ed2BIVZAebb03fbnu7uT840ZAgZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		

		String output = "id,內容,發布日期按，按HAHA總數\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String message = data.select("message").text();
			String created_time = data.select("created_time").text();
			String reactions = data.select("total_count").text();

			output += id+",\""+message+"\","+created_time+","+reactions+"\n";
		}

		System.out.println( output );

	} 
}
