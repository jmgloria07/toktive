package io.github.jmgloria07.toktive.api.objects;

public class ToktiveResponse {
	private String id;
	
	private String url;
	
	private String status;
	
	private ToktiveError error;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ToktiveError getError() {
		return error;
	}

	public void setError(ToktiveError error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "ToktiveResponse [id=" + id + ", url=" + url + ", status=" + status + ", error=" + error + "]";
	}
}
