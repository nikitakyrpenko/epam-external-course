package homework2.bank.domain;

public class Account {

    private Integer id;
    private User user;
    private Integer money;

    public Account(Integer id, User user, Integer money) {
        this.id = id;
        this.user = user;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
