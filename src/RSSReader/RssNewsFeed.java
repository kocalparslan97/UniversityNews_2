package RSSReader;

public class RssNewsFeed {

	public String title;
	public String guId;
	public String pubDate;
	public String link;
	public String content;

	public String getTitle() {
		return title;
	}

	public String getGuId() {
		return guId;
	}

	public String getPubDate() {
		return pubDate;
	}

	public String getLink() {
		return link;
	}

	public String getContent() {
		return content;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGuId(String guId) {
		this.guId = guId;
	}

	public void setPubDate(String fpubDate) {
		this.pubDate = fpubDate;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
