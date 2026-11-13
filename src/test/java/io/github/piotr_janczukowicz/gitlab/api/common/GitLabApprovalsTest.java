package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApprovalsTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabApprovalsBuilder builder = GitLabApprovalsBuilder.builder(CommonCatalogFixtures.approvals())
                .user(null);

        final GitLabApprovals built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedAtIsNullable() {
        final GitLabApprovalsBuilder builder = GitLabApprovalsBuilder.builder(CommonCatalogFixtures.approvals())
                .approvedAt(null);

        final GitLabApprovals built = builder.build();

        assertThat(built.approvedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApprovals value = CommonCatalogFixtures.approvals();

        assertSoftly(softly -> {
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.approvedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApprovals original = CommonCatalogFixtures.approvals();

        final GitLabApprovals rebuilt = GitLabApprovalsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApprovals.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("user", "approvedAt");
    }
}
