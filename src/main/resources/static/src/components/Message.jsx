import { useContext } from "react";
import { UserContext } from "../contexts/UserContext";
import { Flex, Text } from "@mantine/core";
import styles from "../css/General.module.css";

function Message({ data }) {
  // const { user } = useContext(UserContext);

  const user = {
    id: 123,
  };

  return (
    <>
      <Flex py="10px" justify={data.senderId == user.id ? "end" : "start"}>
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
      </Flex>
    </>
  );
}

export default Message;
