-- 178. Rank Scores

-- mysql
select a.Score,b.`Rank` from Scores a,
(
select t.Score,(@row_number:=@row_number+1) as `Rank` from 
(
select distinct Score from Scores order by Score desc
) t,(SELECT @row_number:=0) t2
) b
where a.Score=b.Score 
order by a.Score desc;

-- mysql-5.6.19上，这样也能运行
Set @i:=0;
select a.Score,b.rank from Scores a,
(
select t.Score,(@i:=@i+1) as Rank from 
(
select distinct Score from Scores order by Score desc
) t
) b
where a.Score=b.Score 
order by a.Score desc; 