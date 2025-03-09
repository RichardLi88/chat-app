import { Button, Flex, TextInput } from "@mantine/core";
import styles from "./css/Login.module.css";
import { useForm } from "@mantine/form";
import { replace, useNavigate } from "react-router";
function Login() {
  //used to redirect to messaging home page
  const navigate = useNavigate();

  //using mantine form
  const form = useForm({
    mode: "uncontrolled",
    initialValues: {
      username: "",
      firstname: "",
      lastname: "",
    },

    validate: {
      firstname: (value) =>
        value.length < 2 ? "First name is too short" : null,
      lastname: (value) => (value.length < 2 ? "Last name is too short" : null),
      username: (value) => (value.length < 2 ? "Username is too short" : null),
    },
  });

  function handleSubmit(values) {
    form.validate();
    navigate("/chat");
  }
  return (
    <>
      <Flex w="100vw" h="100vh" justify="center" align="center">
        <Flex className={styles.outline} direction="column" py="30px" px="50px">
          <h1>Enter details here to start chatting!</h1>
          <form onSubmit={form.onSubmit((values) => handleSubmit(values))}>
            <TextInput
              label="Username"
              placeholder="Enter your username here"
              key={form.key("username")}
              {...form.getInputProps("username")}
            />
            <TextInput
              label="First name"
              placeholder="Enter your first name here"
              key={form.key("firstname")}
              {...form.getInputProps("firstname")}
            />
            <TextInput
              label="Last Name"
              placeholder="Enter your last name here"
              key={form.key("lastname")}
              {...form.getInputProps("lastname")}
            />
            <Button variant="filled" type="submit" my="20px" w="100%">
              Start Chatting
            </Button>
          </form>
        </Flex>
      </Flex>
    </>
  );
}

export default Login;
