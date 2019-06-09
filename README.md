# StudentManagementSystem

## Request for name

```sh
curl --location --request GET "http://localhost:8080/students/Ed"
```

## Get all students

```sh
curl --location --request GET "http://localhost:8080/students"
```

## Add a new student

```sh
curl --location --request POST "http://localhost:8080/students" \
  --header "Content-Type: application/json" \
  --data "{
    \"id\": 2,
    \"name\": \"Tom\",
    \"address\": \"Vagabond Inn Fresno\",
    \"dob\": \"1230-09-10\"
}"
```

## Update the student

```sh
curl --location --request PUT "http://localhost:8080/students/2" \
  --header "Content-Type: application/json" \
  --data "{
    \"id\": 2,
    \"name\": \"Tom\",
    \"address\": \"Vagabond Inn Fresno\",
    \"dob\": \"1230-09-10\"
}"
```

## delete student

```sh
curl --location --request DELETE "http://localhost:8080/students/2"
```
