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
class GitLabProjectRemoteMirrorsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectRemoteMirrorsCreatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload())
                        .url(null);

        final GitLabProjectRemoteMirrorsCreatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabProjectRemoteMirrorsCreatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload())
                        .enabled(null);

        final GitLabProjectRemoteMirrorsCreatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthMethodIsNullable() {
        final GitLabProjectRemoteMirrorsCreatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload())
                        .authMethod(null);

        final GitLabProjectRemoteMirrorsCreatePayload built = builder.build();

        assertThat(built.authMethod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepDivergentRefsIsNullable() {
        final GitLabProjectRemoteMirrorsCreatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload())
                        .keepDivergentRefs(null);

        final GitLabProjectRemoteMirrorsCreatePayload built = builder.build();

        assertThat(built.keepDivergentRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyProtectedBranchesIsNullable() {
        final GitLabProjectRemoteMirrorsCreatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload())
                        .onlyProtectedBranches(null);

        final GitLabProjectRemoteMirrorsCreatePayload built = builder.build();

        assertThat(built.onlyProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorBranchRegexIsNullable() {
        final GitLabProjectRemoteMirrorsCreatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload())
                        .mirrorBranchRegex(null);

        final GitLabProjectRemoteMirrorsCreatePayload built = builder.build();

        assertThat(built.mirrorBranchRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHostKeysIsNullable() {
        final GitLabProjectRemoteMirrorsCreatePayloadBuilder builder =
                GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(
                                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload())
                        .hostKeys(null);

        final GitLabProjectRemoteMirrorsCreatePayload built = builder.build();

        assertThat(built.hostKeys()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRemoteMirrorsCreatePayload value =
                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("https://*****:*****@example.com/gitlab/example.git");
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.authMethod()).isEqualTo(GitLabProjectRemoteMirrorsCreateAuthMethod.SSH_PUBLIC_KEY);
            softly.assertThat(value.keepDivergentRefs()).isEqualTo(true);
            softly.assertThat(value.onlyProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.mirrorBranchRegex()).isEqualTo("mirror_branch_regex");
            softly.assertThat(value.hostKeys()).isEqualTo(List.of("host_keys"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRemoteMirrorsCreatePayload original =
                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload();

        final GitLabProjectRemoteMirrorsCreatePayload rebuilt =
                GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenHostKeysSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("host_keys"));
        final GitLabProjectRemoteMirrorsCreatePayload built = GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder(
                        RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload())
                .hostKeys(source)
                .build();
        source.clear();

        assertThat(built.hostKeys()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenHostKeysIsRead() {
        final GitLabProjectRemoteMirrorsCreatePayload built =
                RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload();
        final List<String> values = built.hostKeys();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRemoteMirrorsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "url",
                        "enabled",
                        "authMethod",
                        "keepDivergentRefs",
                        "onlyProtectedBranches",
                        "mirrorBranchRegex",
                        "hostKeys");
    }
}
