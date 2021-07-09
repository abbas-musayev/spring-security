package az.unique.amigossecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static az.unique.amigossecurity.security.UserRoles.*;

@Repository("fake")
public class FakeAppUserDaoServices implements AppUserDao{
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeAppUserDaoServices(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<AppUser> selectAppUserByUsername(String username) {
        return getAppUsers()
                .stream()
                .filter(appUser -> username.equals(appUser.getUsername()))
                .findFirst();
    }
    private List<AppUser> getAppUsers(){
        List<AppUser> appUsers = Lists.newArrayList(
            new AppUser(
                    "abbas",
                    passwordEncoder.encode("123456"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
                    ),
                    new AppUser(
                            "admin",
                            passwordEncoder.encode("123456"),
                            ADMIN.getGrantedAuthorities(),
                            true,
                            true,
                            true,
                            true
                    ),
                    new AppUser(
                            "tom",
                            passwordEncoder.encode("123456"),
                            ADMINTRAINEE.getGrantedAuthorities(),
                            true,
                            true,
                            true,
                            true
            )
        );
        return appUsers;
    }
}
