package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectResourceGroupUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProcessModeIsNullable() {
        final GitLabProjectResourceGroupUpdatePayloadBuilder builder =
                GitLabProjectResourceGroupUpdatePayloadBuilder.builder(
                                ResourcegroupCatalogFixtures.projectResourceGroupUpdatePayload())
                        .processMode(null);

        final GitLabProjectResourceGroupUpdatePayload built = builder.build();

        assertThat(built.processMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectResourceGroupUpdatePayload value =
                ResourcegroupCatalogFixtures.projectResourceGroupUpdatePayload();

        assertThat(value.processMode()).isEqualTo(GitLabProjectResourceGroupUpdateProcessMode.UNORDERED);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectResourceGroupUpdatePayload original =
                ResourcegroupCatalogFixtures.projectResourceGroupUpdatePayload();

        final GitLabProjectResourceGroupUpdatePayload rebuilt =
                GitLabProjectResourceGroupUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectResourceGroupUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("processMode");
    }
}
