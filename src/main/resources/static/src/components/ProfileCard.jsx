import { Avatar, Flex, ScrollArea, Text, Image } from "@mantine/core";
import greenDot from "../img/green_dot.png";
import styles from "../css/General.module.css";
function ProfileCard(name) {
  return (
    <>
      <ScrollArea>
        <Flex
          direction="row"
          bd="0.5px solid gray"
          justify="start"
          px="20px"
          py="5px"
          align="center"
          className={styles.hover}
        >
          <Flex>
            <Avatar radius="xl" color="initials" name={name.name} />
          </Flex>
          <Flex flex="1" justify="center">
            <Text size="xl">{name.name}</Text>
          </Flex>
          <Image src={greenDot} alt="Online" />
        </Flex>
      </ScrollArea>
    </>
  );
}

export default ProfileCard;
