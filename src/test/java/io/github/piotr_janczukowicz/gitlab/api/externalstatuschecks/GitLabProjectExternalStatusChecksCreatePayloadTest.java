package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectExternalStatusChecksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectExternalStatusChecksCreatePayloadBuilder builder =
                GitLabProjectExternalStatusChecksCreatePayloadBuilder.builder(
                                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload())
                        .name(null);

        final GitLabProjectExternalStatusChecksCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedSecretIsNullable() {
        final GitLabProjectExternalStatusChecksCreatePayloadBuilder builder =
                GitLabProjectExternalStatusChecksCreatePayloadBuilder.builder(
                                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload())
                        .sharedSecret(null);

        final GitLabProjectExternalStatusChecksCreatePayload built = builder.build();

        assertThat(built.sharedSecret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabProjectExternalStatusChecksCreatePayloadBuilder builder =
                GitLabProjectExternalStatusChecksCreatePayloadBuilder.builder(
                                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload())
                        .externalUrl(null);

        final GitLabProjectExternalStatusChecksCreatePayload built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchIdsIsNullable() {
        final GitLabProjectExternalStatusChecksCreatePayloadBuilder builder =
                GitLabProjectExternalStatusChecksCreatePayloadBuilder.builder(
                                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload())
                        .protectedBranchIds(null);

        final GitLabProjectExternalStatusChecksCreatePayload built = builder.build();

        assertThat(built.protectedBranchIds()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectExternalStatusChecksCreatePayload value =
                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("QA");
            softly.assertThat(value.sharedSecret()).isEqualTo("hmac-sha256");
            softly.assertThat(value.externalUrl()).isEqualTo("https://www.example.com");
            softly.assertThat(value.protectedBranchIds()).isEqualTo(List.of(1L));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectExternalStatusChecksCreatePayload original =
                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload();

        final GitLabProjectExternalStatusChecksCreatePayload rebuilt =
                GitLabProjectExternalStatusChecksCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenProtectedBranchIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectExternalStatusChecksCreatePayload built =
                GitLabProjectExternalStatusChecksCreatePayloadBuilder.builder(
                                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload())
                        .protectedBranchIds(source)
                        .build();
        source.clear();

        assertThat(built.protectedBranchIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProtectedBranchIdsIsRead() {
        final GitLabProjectExternalStatusChecksCreatePayload built =
                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload();
        final List<Long> values = built.protectedBranchIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenSharedSecretIsACredential() {
        final GitLabProjectExternalStatusChecksCreatePayload value =
                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectExternalStatusChecksCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "sharedSecret", "externalUrl", "protectedBranchIds");
    }
}
