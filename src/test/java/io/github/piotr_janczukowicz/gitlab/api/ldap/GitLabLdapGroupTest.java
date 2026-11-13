package io.github.piotr_janczukowicz.gitlab.api.ldap;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabLdapGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenCnIsNullable() {
        final GitLabLdapGroupBuilder builder =
                GitLabLdapGroupBuilder.builder(LdapCatalogFixtures.ldapGroup()).cn(null);

        final GitLabLdapGroup built = builder.build();

        assertThat(built.cn()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabLdapGroup value = LdapCatalogFixtures.ldapGroup();

        assertThat(value.cn()).isEqualTo("ldap-group-1");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabLdapGroup original = LdapCatalogFixtures.ldapGroup();

        final GitLabLdapGroup rebuilt = GitLabLdapGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabLdapGroup.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("cn");
    }
}
