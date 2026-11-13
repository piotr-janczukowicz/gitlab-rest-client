package io.github.piotr_janczukowicz.gitlab.api.groupissueboards;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIssueBoardsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupIssueBoardsCreatePayloadBuilder builder =
                GitLabGroupGroupIssueBoardsCreatePayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreatePayload())
                        .name(null);

        final GitLabGroupGroupIssueBoardsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIssueBoardsCreatePayload value =
                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreatePayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIssueBoardsCreatePayload original =
                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreatePayload();

        final GitLabGroupGroupIssueBoardsCreatePayload rebuilt =
                GitLabGroupGroupIssueBoardsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIssueBoardsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}
