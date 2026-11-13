package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBillableMembershipTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBillableMembershipBuilder builder = GitLabBillableMembershipBuilder.builder(
                        MembersCatalogFixtures.billableMembership())
                .id(null);

        final GitLabBillableMembership built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIdIsNullable() {
        final GitLabBillableMembershipBuilder builder = GitLabBillableMembershipBuilder.builder(
                        MembersCatalogFixtures.billableMembership())
                .sourceId(null);

        final GitLabBillableMembership built = builder.build();

        assertThat(built.sourceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceFullNameIsNullable() {
        final GitLabBillableMembershipBuilder builder = GitLabBillableMembershipBuilder.builder(
                        MembersCatalogFixtures.billableMembership())
                .sourceFullName(null);

        final GitLabBillableMembership built = builder.build();

        assertThat(built.sourceFullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceMembersUrlIsNullable() {
        final GitLabBillableMembershipBuilder builder = GitLabBillableMembershipBuilder.builder(
                        MembersCatalogFixtures.billableMembership())
                .sourceMembersUrl(null);

        final GitLabBillableMembership built = builder.build();

        assertThat(built.sourceMembersUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabBillableMembershipBuilder builder = GitLabBillableMembershipBuilder.builder(
                        MembersCatalogFixtures.billableMembership())
                .createdAt(null);

        final GitLabBillableMembership built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabBillableMembershipBuilder builder = GitLabBillableMembershipBuilder.builder(
                        MembersCatalogFixtures.billableMembership())
                .expiresAt(null);

        final GitLabBillableMembership built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabBillableMembershipBuilder builder = GitLabBillableMembershipBuilder.builder(
                        MembersCatalogFixtures.billableMembership())
                .accessLevel(null);

        final GitLabBillableMembership built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBillableMembership value = MembersCatalogFixtures.billableMembership();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.sourceId()).isEqualTo(1L);
            softly.assertThat(value.sourceFullName()).isEqualTo("source_full_name");
            softly.assertThat(value.sourceMembersUrl()).isEqualTo("source_members_url");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.accessLevel()).isEqualTo(MembersCatalogFixtures.billableMembershipAccessLevel());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBillableMembership original = MembersCatalogFixtures.billableMembership();

        final GitLabBillableMembership rebuilt =
                GitLabBillableMembershipBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBillableMembership.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "sourceId",
                        "sourceFullName",
                        "sourceMembersUrl",
                        "createdAt",
                        "expiresAt",
                        "accessLevel");
    }
}
