package io.github.piotr_janczukowicz.gitlab.api.metadata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMetadataTest {

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabMetadataBuilder builder = GitLabMetadataBuilder.builder(MetadataCatalogFixtures.metadata())
                .version(null);

        final GitLabMetadata built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabMetadataBuilder builder = GitLabMetadataBuilder.builder(MetadataCatalogFixtures.metadata())
                .revision(null);

        final GitLabMetadata built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKasIsNullable() {
        final GitLabMetadataBuilder builder = GitLabMetadataBuilder.builder(MetadataCatalogFixtures.metadata())
                .kas(null);

        final GitLabMetadata built = builder.build();

        assertThat(built.kas()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnterpriseIsNullable() {
        final GitLabMetadataBuilder builder = GitLabMetadataBuilder.builder(MetadataCatalogFixtures.metadata())
                .enterprise(null);

        final GitLabMetadata built = builder.build();

        assertThat(built.enterprise()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlanIsNullable() {
        final GitLabMetadataBuilder builder = GitLabMetadataBuilder.builder(MetadataCatalogFixtures.metadata())
                .plan(null);

        final GitLabMetadata built = builder.build();

        assertThat(built.plan()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMetadata value = MetadataCatalogFixtures.metadata();

        assertSoftly(softly -> {
            softly.assertThat(value.version()).isEqualTo("15.2-pre");
            softly.assertThat(value.revision()).isEqualTo("c401a659d0c");
            softly.assertThat(value.kas()).isEqualTo(MetadataCatalogFixtures.metadataKas());
            softly.assertThat(value.enterprise()).isEqualTo(true);
            softly.assertThat(value.plan()).isEqualTo("ultimate");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMetadata original = MetadataCatalogFixtures.metadata();

        final GitLabMetadata rebuilt = GitLabMetadataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMetadata.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("version", "revision", "kas", "enterprise", "plan");
    }
}
