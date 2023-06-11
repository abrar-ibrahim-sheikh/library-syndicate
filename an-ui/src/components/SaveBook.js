import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Typography } from '@mui/material';
import { useState } from 'react';
import '@fontsource/roboto/300.css';


export default function SaveBook() {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
        <Typography variant="h4">Add Book</Typography>
        <TextField  id="outlined-basic" label="Title" variant="outlined"></TextField>
        <TextField id="outlined-basic" label="Description" variant="outlined"></TextField>
    </Box>
  );
}
