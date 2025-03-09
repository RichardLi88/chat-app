import { useContext } from "react";
import { UserContext } from "../contexts/UserContext";
import { Avatar, Flex, Text } from "@mantine/core";
import styles from "../css/General.module.css";

function Message({ data }) {
  // const { user } = useContext(UserContext);

  const user = {
    id: 123,
    username: "Richard",
    firstname: "Hello",
    lastname: "World",
  };

  return (
    <>
      <Flex
        py="10px"
        justify={data.senderId == user.id ? "end" : "start"}
        direction={data.senderId == user.id ? "row" : "row-reverse"}
        align="center"
      >
        <Text
          p="10px"
          className={
            data.senderId == user.id
              ? styles["sender-msg"]
              : styles["recipient-msg"]
          }
        >
          {data.content}
        </Text>
        <Avatar name={user.firstname + " " + user.lastname} color="initials" />
      </Flex>
    </>
  );
}

export default Message;
