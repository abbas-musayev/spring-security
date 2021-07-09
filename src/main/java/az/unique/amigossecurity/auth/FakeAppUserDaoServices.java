package az.unique.amigossecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static az.unique.amigossecurity.security.UserRoles.*;

@Repository("fake")
public class AppUserDaoServices implements AppUserDao{
    private final PasswordEncoder passwordEncoder;

    public AppUserDaoServices(PasswordEncoder passwordEncoder) {
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
                    passwordEncoder.encode("password"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
                    ),
                    new AppUser(
                            "admin",
                            passwordEncoder.encode("password"),
                            ADMIN.getGrantedAuthorities(),
                            true,
                            true,
                            true,
                            true
                    ),
                    new AppUser(
                            "tom",
                            passwordEncoder.encode("password"),
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
