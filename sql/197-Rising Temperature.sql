-- 197. Rising Temperature

-- mysql
select w.Id from Weather w, Weather t where datediff(w.RecordDate,t.RecordDate)=1 and w.Temperature>t.Temperature;