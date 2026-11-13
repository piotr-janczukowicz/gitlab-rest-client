package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespacesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersMinutesLimitIsNullable() {
        final GitLabNamespacesUpdatePayloadBuilder builder = GitLabNamespacesUpdatePayloadBuilder.builder(
                        NamespacesCatalogFixtures.namespacesUpdatePayload())
                .sharedRunnersMinutesLimit(null);

        final GitLabNamespacesUpdatePayload built = builder.build();

        assertThat(built.sharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtraSharedRunnersMinutesLimitIsNullable() {
        final GitLabNamespacesUpdatePayloadBuilder builder = GitLabNamespacesUpdatePayloadBuilder.builder(
                        NamespacesCatalogFixtures.namespacesUpdatePayload())
                .extraSharedRunnersMinutesLimit(null);

        final GitLabNamespacesUpdatePayload built = builder.build();

        assertThat(built.extraSharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionalPurchasedStorageSizeIsNullable() {
        final GitLabNamespacesUpdatePayloadBuilder builder = GitLabNamespacesUpdatePayloadBuilder.builder(
                        NamespacesCatalogFixtures.namespacesUpdatePayload())
                .additionalPurchasedStorageSize(null);

        final GitLabNamespacesUpdatePayload built = builder.build();

        assertThat(built.additionalPurchasedStorageSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionalPurchasedStorageEndsOnIsNullable() {
        final GitLabNamespacesUpdatePayloadBuilder builder = GitLabNamespacesUpdatePayloadBuilder.builder(
                        NamespacesCatalogFixtures.namespacesUpdatePayload())
                .additionalPurchasedStorageEndsOn(null);

        final GitLabNamespacesUpdatePayload built = builder.build();

        assertThat(built.additionalPurchasedStorageEndsOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabSubscriptionAttributesIsNullable() {
        final GitLabNamespacesUpdatePayloadBuilder builder = GitLabNamespacesUpdatePayloadBuilder.builder(
                        NamespacesCatalogFixtures.namespacesUpdatePayload())
                .gitlabSubscriptionAttributes(null);

        final GitLabNamespacesUpdatePayload built = builder.build();

        assertThat(built.gitlabSubscriptionAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespacesUpdatePayload value = NamespacesCatalogFixtures.namespacesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sharedRunnersMinutesLimit()).isEqualTo(1);
            softly.assertThat(value.extraSharedRunnersMinutesLimit()).isEqualTo(1);
            softly.assertThat(value.additionalPurchasedStorageSize()).isEqualTo(1L);
            softly.assertThat(value.additionalPurchasedStorageEndsOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.gitlabSubscriptionAttributes())
                    .isEqualTo(NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespacesUpdatePayload original = NamespacesCatalogFixtures.namespacesUpdatePayload();

        final GitLabNamespacesUpdatePayload rebuilt =
                GitLabNamespacesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNamespacesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "sharedRunnersMinutesLimit",
                        "extraSharedRunnersMinutesLimit",
                        "additionalPurchasedStorageSize",
                        "additionalPurchasedStorageEndsOn",
                        "gitlabSubscriptionAttributes");
    }
}
