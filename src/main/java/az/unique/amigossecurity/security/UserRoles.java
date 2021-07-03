package az.unique.amigossecurity.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static az.unique.amigossecurity.security.UserPermission.*;

public enum UserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE));

    private final Set<UserPermission> userPermissions;

    UserRoles(Set<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }
}