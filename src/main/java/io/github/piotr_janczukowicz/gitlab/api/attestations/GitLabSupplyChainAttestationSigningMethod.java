package io.github.piotr_janczukowicz.gitlab.api.attestations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab supply chain attestation signing method. */
@CatalogSchema("components/schemas/APIEntitiesSupplyChainAttestation/properties/signing_method")
public enum GitLabSupplyChainAttestationSigningMethod {
    SIGSTORE("sigstore"),
    LOCAL_CA("local_ca"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabSupplyChainAttestationSigningMethod> WIRE_INDEX = EnumUtils.index(
            GitLabSupplyChainAttestationSigningMethod.class, GitLabSupplyChainAttestationSigningMethod::wireValue);

    private final String wireValue;

    GitLabSupplyChainAttestationSigningMethod(final String wireValue) {
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
     */
    @JsonCreator
    public static GitLabSupplyChainAttestationSigningMethod fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
