package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group group webhooks call events status. */
@CatalogSchema("operations/getApiV4GroupsIdHooksHookIdEvents/parameters/status/schema/items")
public enum GitLabGroupGroupWebhooksCallEventsStatus {
    N_100("100"),
    N_101("101"),
    N_102("102"),
    N_103("103"),
    N_200("200"),
    N_201("201"),
    N_202("202"),
    N_203("203"),
    N_204("204"),
    N_205("205"),
    N_206("206"),
    N_207("207"),
    N_208("208"),
    N_226("226"),
    N_300("300"),
    N_301("301"),
    N_302("302"),
    N_303("303"),
    N_304("304"),
    N_305("305"),
    N_306("306"),
    N_307("307"),
    N_308("308"),
    N_400("400"),
    N_401("401"),
    N_402("402"),
    N_403("403"),
    N_404("404"),
    N_405("405"),
    N_406("406"),
    N_407("407"),
    N_408("408"),
    N_409("409"),
    N_410("410"),
    N_411("411"),
    N_412("412"),
    N_413("413"),
    N_414("414"),
    N_415("415"),
    N_416("416"),
    N_417("417"),
    N_421("421"),
    N_422("422"),
    N_423("423"),
    N_424("424"),
    N_425("425"),
    N_426("426"),
    N_428("428"),
    N_429("429"),
    N_431("431"),
    N_451("451"),
    N_500("500"),
    N_501("501"),
    N_502("502"),
    N_503("503"),
    N_504("504"),
    N_505("505"),
    N_506("506"),
    N_507("507"),
    N_508("508"),
    N_509("509"),
    N_510("510"),
    N_511("511"),
    SUCCESSFUL("successful"),
    CLIENT_FAILURE("client_failure"),
    SERVER_FAILURE("server_failure");

    private static final EnumUtils.WireIndex<GitLabGroupGroupWebhooksCallEventsStatus> WIRE_INDEX = EnumUtils.index(
            GitLabGroupGroupWebhooksCallEventsStatus.class, GitLabGroupGroupWebhooksCallEventsStatus::wireValue);

    private final String wireValue;

    GitLabGroupGroupWebhooksCallEventsStatus(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabGroupGroupWebhooksCallEventsStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
