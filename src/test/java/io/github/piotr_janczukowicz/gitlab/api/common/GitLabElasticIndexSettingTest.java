package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabElasticIndexSettingTest {

    @Test
    void constructor_shouldAcceptNull_whenAliasNameIsNullable() {
        final GitLabElasticIndexSettingBuilder builder = GitLabElasticIndexSettingBuilder.builder(
                        CommonCatalogFixtures.elasticIndexSetting())
                .aliasName(null);

        final GitLabElasticIndexSetting built = builder.build();

        assertThat(built.aliasName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNumberOfShardsIsNullable() {
        final GitLabElasticIndexSettingBuilder builder = GitLabElasticIndexSettingBuilder.builder(
                        CommonCatalogFixtures.elasticIndexSetting())
                .numberOfShards(null);

        final GitLabElasticIndexSetting built = builder.build();

        assertThat(built.numberOfShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNumberOfReplicasIsNullable() {
        final GitLabElasticIndexSettingBuilder builder = GitLabElasticIndexSettingBuilder.builder(
                        CommonCatalogFixtures.elasticIndexSetting())
                .numberOfReplicas(null);

        final GitLabElasticIndexSetting built = builder.build();

        assertThat(built.numberOfReplicas()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabElasticIndexSetting value = CommonCatalogFixtures.elasticIndexSetting();

        assertSoftly(softly -> {
            softly.assertThat(value.aliasName()).isEqualTo("gitlab-production");
            softly.assertThat(value.numberOfShards()).isEqualTo(1);
            softly.assertThat(value.numberOfReplicas()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabElasticIndexSetting original = CommonCatalogFixtures.elasticIndexSetting();

        final GitLabElasticIndexSetting rebuilt =
                GitLabElasticIndexSettingBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabElasticIndexSetting.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("aliasName", "numberOfShards", "numberOfReplicas");
    }
}
