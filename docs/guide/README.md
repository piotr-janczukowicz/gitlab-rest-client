# User guide

The [README](../../README.md) is the short version: a client in a few lines. These pages are the detail behind it. The
transport itself (configuration, authentication, rate limits and errors) is described once in the
[gitlab-client user guide](https://github.com/piotr-janczukowicz/gitlab-client/blob/main/docs/guide/README.md), which applies
to this library too. Read these pages in order, or jump to the one you need.

| Chapter | What it covers |
|---|---|
| 1. [Pagination](pagination.md) | Offset and keyset lists, `all()`, `stream()`, `forEachPage(...)` and the page cap |
| 2. [Immutability](immutability.md) | Immutable records, unmodifiable collections, `null` for absent fields, copied inputs |
| 3. [Good to know](good-to-know.md) | Names, `UNRECOGNIZED`, deprecated operations, GitLab's description and its mistakes |
| 4. [Live smoke tests](smoke-tests.md) | Running the opt-in tests against a GitLab instance |
