package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

public final class LdapgrouplinksCatalogFixtures {

    private LdapgrouplinksCatalogFixtures() {}

    public static GitLabGroupLDAPGroupLinksCreatePayload groupLDAPGroupLinksCreatePayload() {
        return GitLabGroupLDAPGroupLinksCreatePayloadBuilder.builder()
                .cn("cn")
                .filter("filter")
                .groupAccess(GitLabGroupLDAPGroupLinksCreateGroupAccess.N_5)
                .provider("provider")
                .memberRoleId(1L)
                .build();
    }
}
