package io.github.jmgloria07.toktive.api.objects;

public class ToktiveResponse {
	private String id;
	
	private String url;
	
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ToktiveResponse [id=" + id + ", url=" + url + ", status=" + status + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
