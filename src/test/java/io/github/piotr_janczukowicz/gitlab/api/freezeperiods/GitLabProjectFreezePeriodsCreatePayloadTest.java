package io.github.piotr_janczukowicz.gitlab.api.freezeperiods;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFreezePeriodsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenFreezeStartIsNullable() {
        final GitLabProjectFreezePeriodsCreatePayloadBuilder builder =
                GitLabProjectFreezePeriodsCreatePayloadBuilder.builder(
                                FreezeperiodsCatalogFixtures.projectFreezePeriodsCreatePayload())
                        .freezeStart(null);

        final GitLabProjectFreezePeriodsCreatePayload built = builder.build();

        assertThat(built.freezeStart()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFreezeEndIsNullable() {
        final GitLabProjectFreezePeriodsCreatePayloadBuilder builder =
                GitLabProjectFreezePeriodsCreatePayloadBuilder.builder(
                                FreezeperiodsCatalogFixtures.projectFreezePeriodsCreatePayload())
                        .freezeEnd(null);

        final GitLabProjectFreezePeriodsCreatePayload built = builder.build();

        assertThat(built.freezeEnd()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronTimezoneIsNullable() {
        final GitLabProjectFreezePeriodsCreatePayloadBuilder builder =
                GitLabProjectFreezePeriodsCreatePayloadBuilder.builder(
                                FreezeperiodsCatalogFixtures.projectFreezePeriodsCreatePayload())
                        .cronTimezone(null);

        final GitLabProjectFreezePeriodsCreatePayload built = builder.build();

        assertThat(built.cronTimezone()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFreezePeriodsCreatePayload value =
                FreezeperiodsCatalogFixtures.projectFreezePeriodsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.freezeStart()).isEqualTo("freeze_start");
            softly.assertThat(value.freezeEnd()).isEqualTo("freeze_end");
            softly.assertThat(value.cronTimezone()).isEqualTo("cron_timezone");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFreezePeriodsCreatePayload original =
                FreezeperiodsCatalogFixtures.projectFreezePeriodsCreatePayload();

        final GitLabProjectFreezePeriodsCreatePayload rebuilt =
                GitLabProjectFreezePeriodsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFreezePeriodsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("freezeStart", "freezeEnd", "cronTimezone");
    }
}
