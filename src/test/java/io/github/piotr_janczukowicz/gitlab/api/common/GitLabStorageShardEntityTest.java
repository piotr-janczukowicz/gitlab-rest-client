package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabStorageShardEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabStorageShardEntityBuilder builder = GitLabStorageShardEntityBuilder.builder(
                        CommonCatalogFixtures.storageShardEntity())
                .name(null);

        final GitLabStorageShardEntity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabStorageShardEntity value = CommonCatalogFixtures.storageShardEntity();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabStorageShardEntity original = CommonCatalogFixtures.storageShardEntity();

        final GitLabStorageShardEntity rebuilt =
                GitLabStorageShardEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabStorageShardEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}
