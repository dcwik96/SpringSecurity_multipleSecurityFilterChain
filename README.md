# SpringSecurity_multipleSecurityFilterChain

curl localhost:8081/securedWithToken
curl --header "Authorization: Bearer sekretnyToken" localhost:8081/securedWithToken
curl --header "Authorization: Basic user:password" localhost:8081/securedWithToken

curl localhost:8081/securedWithUser
curl --header "Authorization: Bearer sekretnyToken" localhost:8081/securedWithUser
curl --header "Authorization: Basic user:password" localhost:8081/securedWithUser

curl localhost:8081/all

curl localhost:8081/cosconieistnieje