package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

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
class GitLabProjectRemoteMirrorsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabProjectRemoteMirrorsUpdatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload())
                        .enabled(null);

        final GitLabProjectRemoteMirrorsUpdatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthMethodIsNullable() {
        final GitLabProjectRemoteMirrorsUpdatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload())
                        .authMethod(null);

        final GitLabProjectRemoteMirrorsUpdatePayload built = builder.build();

        assertThat(built.authMethod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepDivergentRefsIsNullable() {
        final GitLabProjectRemoteMirrorsUpdatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload())
                        .keepDivergentRefs(null);

        final GitLabProjectRemoteMirrorsUpdatePayload built = builder.build();

        assertThat(built.keepDivergentRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyProtectedBranchesIsNullable() {
        final GitLabProjectRemoteMirrorsUpdatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload())
                        .onlyProtectedBranches(null);

        final GitLabProjectRemoteMirrorsUpdatePayload built = builder.build();

        assertThat(built.onlyProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorBranchRegexIsNullable() {
        final GitLabProjectRemoteMirrorsUpdatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload())
                        .mirrorBranchRegex(null);

        final GitLabProjectRemoteMirrorsUpdatePayload built = builder.build();

        assertThat(built.mirrorBranchRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHostKeysIsNullable() {
        final GitLabProjectRemoteMirrorsUpdatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload())
                        .hostKeys(null);

        final GitLabProjectRemoteMirrorsUpdatePayload built = builder.build();

        assertThat(built.hostKeys()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRemoteMirrorsUpdatePayload value =
                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.authMethod()).isEqualTo("auth_method");
            softly.assertThat(value.keepDivergentRefs()).isEqualTo(true);
            softly.assertThat(value.onlyProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.mirrorBranchRegex()).isEqualTo("mirror_branch_regex");
            softly.assertThat(value.hostKeys()).isEqualTo(List.of("host_keys"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRemoteMirrorsUpdatePayload original =
                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload();

        final GitLabProjectRemoteMirrorsUpdatePayload rebuilt =
                GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenHostKeysSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("host_keys"));
        final GitLabProjectRemoteMirrorsUpdatePayload built = GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder(
                        RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload())
                .hostKeys(source)
                .build();
        source.clear();

        assertThat(built.hostKeys()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenHostKeysIsRead() {
        final GitLabProjectRemoteMirrorsUpdatePayload built =
                RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload();
        final List<String> values = built.hostKeys();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRemoteMirrorsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "enabled",
                        "authMethod",
                        "keepDivergentRefs",
                        "onlyProtectedBranches",
                        "mirrorBranchRegex",
                        "hostKeys");
    }
}
