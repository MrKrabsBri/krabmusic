import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';

export default function Song() {
  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 2, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Song Name" variant="outlined" />
      <TextField id="outlined-basic" label="Song Description" variant="outlined" />

    </Box>
  );
}
