package io.github.piotr_janczukowicz.gitlab.api.freezeperiods;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFreezePeriodsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenFreezeStartIsNullable() {
        final GitLabProjectFreezePeriodsUpdatePayloadBuilder builder =
                GitLabProjectFreezePeriodsUpdatePayloadBuilder.builder(
                                FreezeperiodsCatalogFixtures.projectFreezePeriodsUpdatePayload())
                        .freezeStart(null);

        final GitLabProjectFreezePeriodsUpdatePayload built = builder.build();

        assertThat(built.freezeStart()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFreezeEndIsNullable() {
        final GitLabProjectFreezePeriodsUpdatePayloadBuilder builder =
                GitLabProjectFreezePeriodsUpdatePayloadBuilder.builder(
                                FreezeperiodsCatalogFixtures.projectFreezePeriodsUpdatePayload())
                        .freezeEnd(null);

        final GitLabProjectFreezePeriodsUpdatePayload built = builder.build();

        assertThat(built.freezeEnd()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronTimezoneIsNullable() {
        final GitLabProjectFreezePeriodsUpdatePayloadBuilder builder =
                GitLabProjectFreezePeriodsUpdatePayloadBuilder.builder(
                                FreezeperiodsCatalogFixtures.projectFreezePeriodsUpdatePayload())
                        .cronTimezone(null);

        final GitLabProjectFreezePeriodsUpdatePayload built = builder.build();

        assertThat(built.cronTimezone()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFreezePeriodsUpdatePayload value =
                FreezeperiodsCatalogFixtures.projectFreezePeriodsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.freezeStart()).isEqualTo("freeze_start");
            softly.assertThat(value.freezeEnd()).isEqualTo("freeze_end");
            softly.assertThat(value.cronTimezone()).isEqualTo("cron_timezone");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFreezePeriodsUpdatePayload original =
                FreezeperiodsCatalogFixtures.projectFreezePeriodsUpdatePayload();

        final GitLabProjectFreezePeriodsUpdatePayload rebuilt =
                GitLabProjectFreezePeriodsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFreezePeriodsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("freezeStart", "freezeEnd", "cronTimezone");
    }
}
