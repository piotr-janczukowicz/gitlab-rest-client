package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBillableMembershipAccessLevelTest {

    @Test
    void constructor_shouldAcceptNull_whenStringValueIsNullable() {
        final GitLabBillableMembershipAccessLevelBuilder builder = GitLabBillableMembershipAccessLevelBuilder.builder(
                        MembersCatalogFixtures.billableMembershipAccessLevel())
                .stringValue(null);

        final GitLabBillableMembershipAccessLevel built = builder.build();

        assertThat(built.stringValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntegerValueIsNullable() {
        final GitLabBillableMembershipAccessLevelBuilder builder = GitLabBillableMembershipAccessLevelBuilder.builder(
                        MembersCatalogFixtures.billableMembershipAccessLevel())
                .integerValue(null);

        final GitLabBillableMembershipAccessLevel built = builder.build();

        assertThat(built.integerValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomRoleIsNullable() {
        final GitLabBillableMembershipAccessLevelBuilder builder = GitLabBillableMembershipAccessLevelBuilder.builder(
                        MembersCatalogFixtures.billableMembershipAccessLevel())
                .customRole(null);

        final GitLabBillableMembershipAccessLevel built = builder.build();

        assertThat(built.customRole()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBillableMembershipAccessLevel value = MembersCatalogFixtures.billableMembershipAccessLevel();

        assertSoftly(softly -> {
            softly.assertThat(value.stringValue()).isEqualTo("string_value");
            softly.assertThat(value.integerValue()).isEqualTo(1);
            softly.assertThat(value.customRole()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBillableMembershipAccessLevel original = MembersCatalogFixtures.billableMembershipAccessLevel();

        final GitLabBillableMembershipAccessLevel rebuilt =
                GitLabBillableMembershipAccessLevelBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBillableMembershipAccessLevel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("stringValue", "integerValue", "customRole");
    }
}
