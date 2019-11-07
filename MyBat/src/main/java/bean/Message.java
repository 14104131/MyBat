package bean;

/**
 * 与消息表对应的实体类
 */
public class Message {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 指令名称
     */
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
