package io.github.piotr_janczukowicz.gitlab.api.ldap;

public final class LdapCatalogFixtures {

    private LdapCatalogFixtures() {}

    public static GitLabLdapGroup ldapGroup() {
        return GitLabLdapGroupBuilder.builder().cn("ldap-group-1").build();
    }
}
