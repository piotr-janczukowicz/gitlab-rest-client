# gitlab-rest-client

Java 21 client for the [GitLab REST API](https://docs.gitlab.com/api/rest/): typed models and operations for gitlab.com,
GitLab Dedicated and self-managed GitLab, with pagination, rate-limit handling and a tier guard built in.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.piotr-janczukowicz/gitlab-rest-client)](https://central.sonatype.com/artifact/io.github.piotr-janczukowicz/gitlab-rest-client)
![Java 21](https://img.shields.io/badge/Java-21-orange.svg)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Build](https://github.com/piotr-janczukowicz/gitlab-rest-client/actions/workflows/main.yml/badge.svg)](https://github.com/piotr-janczukowicz/gitlab-rest-client/actions/workflows/main.yml)
[![Codacy Coverage](https://app.codacy.com/project/badge/Coverage/04ddc44afba54f689407bf677619d562)](https://app.codacy.com/gh/piotr-janczukowicz/gitlab-rest-client/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_Coverage)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/04ddc44afba54f689407bf677619d562)](https://app.codacy.com/gh/piotr-janczukowicz/gitlab-rest-client/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_Grade)

**API version:** `19.6` (the version of GitLab's OpenAPI description)

## Why this library

- **Typed.** Every resource has a typed `GitLab*Api` class and typed models, filters and payloads, following the
  [OpenAPI description](https://docs.gitlab.com/api/openapi/openapi_v3/) that GitLab publishes.
- **One client for every GitLab.** gitlab.com, GitLab Dedicated and self-managed, with an optional check that rejects a call
  your instance's tier lacks before it is sent.
- **Safe when GitLab adds values.** A response value the library does not know decodes to `UNRECOGNIZED` instead of
  throwing, so a new enum value on GitLab's side does not break your code.
- **The boring parts are handled.** Rate limits are waited out, offset and keyset pagination are followed and responses are
  immutable.
- **Small on purpose.** Synchronous REST only: no async API, no GraphQL.

## Install

**Requirements:** Java 21. The library is a Java module, `io.github.piotr_janczukowicz.gitlabrestclient`, and also works on
the class path. It is published on
[Maven Central](https://central.sonatype.com/artifact/io.github.piotr-janczukowicz/gitlab-rest-client):

```xml
<dependency>
    <groupId>io.github.piotr-janczukowicz</groupId>
    <artifactId>gitlab-rest-client</artifactId>
    <version>LATEST_VERSION</version>
</dependency>
```

Replace `LATEST_VERSION` with the version in the Maven Central badge at the top of this page, or with the newest entry on
the [releases page](https://github.com/piotr-janczukowicz/gitlab-rest-client/releases). The library is new and not yet proven
in production; see the [Disclaimer](#disclaimer) before relying on it.

## Quick start

```java
try (GitLabClient client = GitLabClients.create(
        GitLabAuthenticationProviders.personalToken(System.getenv("GITLAB_TOKEN")), "my-app/1.0")) {
    GitLab gitLab = GitLab.of(client);

    for (GitLabIssue issue : gitLab.issues().project().list("my-group/my-project").all()) {
        System.out.println(issue.iid() + " " + issue.title());
    }
}
```

## Usage

A resource is reached through the `GitLab` facade: every page of GitLab's REST documentation is one accessor. A page that
exists for projects, groups and the instance is an aggregator with `project()`, `group()` and `instance()`, for example
`gitLab.issues().project()`. The Javadoc of each method names the HTTP request it sends. Request bodies are `...Payload`
records and query filters are `...Filter` records; both have a `...Builder`, and a filter has `empty()`. A lookup of one
resource returns an `Optional` (a 404 is an empty result), and a list returns a `GitLabPage`.

A project or group is given as its numeric id or its URL-encoded path (`my-group/my-project`).

**Client lifecycle.** Create one `GitLabClient` per credential: it owns the transport and the rate-limit state.
`GitLab.of(client)` gives every resource, created on first use. `client.close()` closes the transport, and a second
credential needs its own client. Clients and resources are thread-safe; a `GitLabPage` is not.

## Self-managed GitLab and tiers

The client sends requests to `/api/v4` of an instance root, `https://gitlab.com` by default.

```java
GitLabClientConfiguration configuration = GitLabClientConfiguration.builder()
        .baseUri(URI.create("https://gitlab.example.com"))
        .tier(GitLabTier.PREMIUM)
        .build();
GitLabClient client = GitLabClients.create(
        GitLabAuthenticationProviders.personalToken(token), "my-app/1.0", configuration);
```

| Product | Client flavor | Tier |
|---|---|---|
| GitLab.com | `GITLAB_COM`, from the host | not settable: a subscription belongs to a top-level group |
| GitLab Dedicated | `DEDICATED`, set it | `FREE`, `PREMIUM` or `ULTIMATE` |
| Self-managed | `SELF_MANAGED`, from the host | `FREE`, `PREMIUM` or `ULTIMATE` |

An operation that needs a tier carries `@RequiresTier`. With a tier configured, a call the tier lacks fails with
`GitLabTierException` before any request is sent; without one, such a call fails with GitLab's own `403` or `404`.

## Authentication

Every client sends one credential, chosen by its authentication provider. For another credential, create another client.
GitLab's rules are in its [authentication documentation](https://docs.gitlab.com/api/rest/authentication/).

| You have | Use |
|---|---|
| A personal, project or group access token | `GitLabAuthenticationProviders.personalToken(token)` |
| An OAuth 2.0 token | `GitLabAuthenticationProviders.oauth(token)` |
| The token of a CI/CD job | `GitLabAuthenticationProviders.jobToken(token)` |
| A token that changes (refreshed OAuth, rotated access token) | `GitLabAuthenticationProviders.rotatingToken(identity, supplier)` |

## User guide

The [user guide](docs/guide/README.md) has a chapter for each topic below.

| Topic | In short |
|---|---|
| [Transport guide](https://github.com/piotr-janczukowicz/gitlab-client/blob/main/docs/guide/README.md) | Configuration, authentication in depth, rate limiting and exception handling, described once in the `gitlab-client` user guide |
| [Pagination](docs/guide/pagination.md) | A `GitLabPage` per HTTP page; offset and keyset lists; `all()`, `stream()` and the page cap |
| [Immutability](docs/guide/immutability.md) | Immutable records, absent fields are `null`, your inputs are copied |
| [Good to know](docs/guide/good-to-know.md) | Names, `UNRECOGNIZED`, deprecated operations and the caveats of GitLab's description |
| [Live smoke tests](docs/guide/smoke-tests.md) | Running the opt-in tests against a GitLab instance |

## Limitations

- **Authentication.** Access tokens, OAuth tokens, job tokens and a supplier for a changing token are covered. The client does
  not run interactive OAuth flows; obtain the token yourself.
- **Operations.** A few operations that no Java type can model without `Object` are not included, for example a JSON-RPC
  endpoint whose `params` is an object or an array.
- **Memory.** A response is read into memory in full, up to the transport's size limit; a larger body fails with
  `ResponseTooLargeException`.

## Disclaimer

This library follows the OpenAPI description that GitLab publishes, which GitLab generates from its code and which contains
mistakes, and the caveats of that description apply here too (see [Good to know](docs/guide/good-to-know.md)). The
description is licensed under [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0/), copyright GitLab Inc. and
contributors. This library copies none of its text.

This is an independent project. It is not made, endorsed or sponsored by GitLab Inc.; "GitLab" is a trademark of GitLab
Inc., used here only to say what the library talks to.

**Only smoke tests have been run on the live GitLab environment, covering particular feature sets. Not every endpoint has
been tested: administrator, licence-gated and organization endpoints in particular were not run live. This library is new and
not yet proven in production. Verify the behavior of any endpoint you depend on before using it in production.**

## License

[MIT](LICENSE)
