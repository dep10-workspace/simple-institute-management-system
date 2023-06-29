import express from 'express'
import { router as courseRouter} from './api/courseHttpController'


const app =express();
app.listen('8081',()=>console.log("server has started"));
app.use('/api/v1/courses',courseRouter);



