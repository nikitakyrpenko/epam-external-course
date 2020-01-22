package bank.domain;
import bank.utility.CollectionUtility;
import java.util.List;
import java.util.Objects;

public class User {

    private final Integer id;
    private final String email;
    private final String password;
    private final String telephone;
    private final List<Account> accounts;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() { return telephone; }

    public List<Account> getAccounts() {
        return accounts;
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.telephone = builder.telephone;
        this.accounts = CollectionUtility.nullSafetyListInitialize(builder.accounts);
    }

    public static Builder builder() { return new Builder();}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(accounts, user.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, accounts);
    }

    public static class Builder{
        private  Integer id;
        private  String email;
        private  String password;
        private String telephone;
        private  List<Account> accounts;


        private Builder(){}

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }

        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public Builder withPassword(String password){
            this.password = password;
            return this;
        }

        public Builder withTelephone(String telephone){
            this.telephone = telephone;
            return this;
        }

        public Builder withAccount(List<Account> accounts){
            this.accounts = accounts;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) {return false;}
            Builder builder = (Builder) o;
            return Objects.equals(id, builder.id) &&
                    Objects.equals(email, builder.email) &&
                    Objects.equals(password, builder.password) &&
                    Objects.equals(accounts, builder.accounts);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, email, password, accounts);
        }

        public User build(){
            return new User(this);
        }

    }
}
