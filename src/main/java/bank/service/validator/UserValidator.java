package bank.service.validator;

import bank.domain.User;
import bank.exception.ValidateException;

import java.util.regex.Pattern;

public class UserValidator implements Validator<User>{

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&*+/=?`{}~^.-]+@[a-zA-Z0-9.-]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("([+]*38[(]?[0-9]{1,4}[)]?[-\\s./0-9]*)");

    @Override
    public void validate(User user) {
        if (!EMAIL_PATTERN.matcher(user.getEmail()).matches()){
            throw new ValidateException("Email do not match the pattern");
        }else if (!PASSWORD_PATTERN.matcher(user.getPassword()).matches()){
            throw new ValidateException("Password do not match the pattern");
        }else if (!TELEPHONE_PATTERN.matcher(user.getTelephone()).matches()){
            throw new ValidateException("Telephone do not match the pattern");
        }
    }
}
