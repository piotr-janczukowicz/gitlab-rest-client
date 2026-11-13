package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTerraformStateCreateStateLockPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .id(null);

        final GitLabProjectTerraformStateCreateStateLockPayload built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenIdIsTooLong() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .id("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenIdHasTheMaximumLength() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .id("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOperationIsNullable() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .operation(null);

        final GitLabProjectTerraformStateCreateStateLockPayload built = builder.build();

        assertThat(built.operation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInfoIsNullable() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .info(null);

        final GitLabProjectTerraformStateCreateStateLockPayload built = builder.build();

        assertThat(built.info()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWhoIsNullable() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .who(null);

        final GitLabProjectTerraformStateCreateStateLockPayload built = builder.build();

        assertThat(built.who()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .version(null);

        final GitLabProjectTerraformStateCreateStateLockPayload built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedIsNullable() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .created(null);

        final GitLabProjectTerraformStateCreateStateLockPayload built = builder.build();

        assertThat(built.created()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectTerraformStateCreateStateLockPayloadBuilder builder =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload())
                        .path(null);

        final GitLabProjectTerraformStateCreateStateLockPayload built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTerraformStateCreateStateLockPayload value =
                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("ID");
            softly.assertThat(value.operation()).isEqualTo("Operation");
            softly.assertThat(value.info()).isEqualTo("Info");
            softly.assertThat(value.who()).isEqualTo("Who");
            softly.assertThat(value.version()).isEqualTo("Version");
            softly.assertThat(value.created()).isEqualTo("Created");
            softly.assertThat(value.path()).isEqualTo("Path");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTerraformStateCreateStateLockPayload original =
                TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload();

        final GitLabProjectTerraformStateCreateStateLockPayload rebuilt =
                GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectTerraformStateCreateStateLockPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "operation", "info", "who", "version", "created", "path");
    }
}
