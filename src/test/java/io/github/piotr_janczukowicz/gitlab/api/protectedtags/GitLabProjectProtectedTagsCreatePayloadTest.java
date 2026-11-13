package io.github.piotr_janczukowicz.gitlab.api.protectedtags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProtectedTagsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProtectedTagsCreatePayloadBuilder builder =
                GitLabProjectProtectedTagsCreatePayloadBuilder.builder(
                                ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload())
                        .name(null);

        final GitLabProjectProtectedTagsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreateAccessLevelIsNullable() {
        final GitLabProjectProtectedTagsCreatePayloadBuilder builder =
                GitLabProjectProtectedTagsCreatePayloadBuilder.builder(
                                ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload())
                        .createAccessLevel(null);

        final GitLabProjectProtectedTagsCreatePayload built = builder.build();

        assertThat(built.createAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToCreateIsNullable() {
        final GitLabProjectProtectedTagsCreatePayloadBuilder builder =
                GitLabProjectProtectedTagsCreatePayloadBuilder.builder(
                                ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload())
                        .allowedToCreate(null);

        final GitLabProjectProtectedTagsCreatePayload built = builder.build();

        assertThat(built.allowedToCreate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedTagsCreatePayload value =
                ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("release-1-0");
            softly.assertThat(value.createAccessLevel())
                    .isEqualTo(GitLabProjectProtectedTagsCreateAccessLevel.DEVELOPER);
            softly.assertThat(value.allowedToCreate()).isEqualTo(List.of(Map.of("key", "value")));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedTagsCreatePayload original =
                ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload();

        final GitLabProjectProtectedTagsCreatePayload rebuilt =
                GitLabProjectProtectedTagsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToCreateSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProtectedTagsCreatePayload built = GitLabProjectProtectedTagsCreatePayloadBuilder.builder(
                        ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload())
                .allowedToCreate(source)
                .build();
        source.clear();

        assertThat(built.allowedToCreate()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToCreateIsRead() {
        final GitLabProjectProtectedTagsCreatePayload built =
                ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload();
        final List<Map<String, Object>> values = built.allowedToCreate();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProtectedTagsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "createAccessLevel", "allowedToCreate");
    }
}
