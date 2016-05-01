package eus.ehu.informatica.gestionalumno.service.mensajes;

public class Mensaje {
	public static final String MSG_TYPE_SUCCESS = "success";
	public static final String MSG_TYPE_INFO = "info";
	public static final String MSG_TYPE_WARNING = "warning";
	public static final String MSG_TYPE_DANGER = "danger";

	String msg; // literal del mensaje
	String type; // tipo de mensaje [success,info,warning,danger]
	int code; // codigo http

	public Mensaje(final String msg) {
		super();
		this.msg = msg;
		this.type = MSG_TYPE_SUCCESS;
	}

	public Mensaje(final String msg, final String type) {
		super();
		this.msg = msg;
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(final String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(final int code) {
		this.code = code;
	}
}
