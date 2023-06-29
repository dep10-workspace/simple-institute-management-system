import express, {json} from 'express'
import { router as courseRouter} from './api/courseHttpController'
import cors from 'cors'



const app =express();
app.listen('8080',()=>console.log("server has started"));
app.use(cors());
app.use(json())
app.use('/api/v1/courses',courseRouter);



