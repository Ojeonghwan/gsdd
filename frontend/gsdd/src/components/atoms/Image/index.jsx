import React from "react";
import styled, {css} from "styled-components";

// width 길이만 설정해서 원본 비율은 유지
const size = css`
    ${({theme, size}) => 
        css`
            width: ${theme.contentSizes[size]};
        `
    }
`

const StyledImage = styled.img`
    width: 100%;
    height: 100%;
    object-fit: cover;
    ${size}
`

const Image = ({size}) => {
    return(
        <StyledImage size={size} />
    )
}

export default Image;