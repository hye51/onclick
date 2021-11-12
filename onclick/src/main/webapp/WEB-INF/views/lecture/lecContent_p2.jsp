<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>


<meta http-ｅquiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<style>
		.progress {
  flex: 10;
  position: relative;
  display: flex;
  flex-basis: 100%;
  height: 5px;
  transition: height 0.3s;
  background: rgba(0, 0, 0, 0.5);
  cursor: ew-resize;
}

.progress__filled {
  width: 50%;
  background: #ffc600;
  flex: 0;
  flex-basis: 50%;
}
		</style>
<header>

<body >

<video class="viewer" controls >

	<source class = "player" src="<%=request.getContextPath()%>/resources/assets/video/test4.mp4" type="video/mp4">

</video>

 <button data-skip="-10" class="player__button">« 10s</button>
 <button data-skip="25" class="player__button">25s »</button>
<button class="player__button toggle" title="Toggle Play">►</button>


<div class="progress">
<div class="progress__filled"></div>
</div>


</body>
<script type="text/javascript">
const player = document.querySelector('.player');
const video = player.querySelector('.viewer');
const progress = player.querySelector('.progress');
const progressBar = player.querySelector('.progress__filled');
const toggle = player.querySelector('.toggle');
const skipButtons = player.querySelectorAll('[data-skip]');
const ranges = player.querySelectorAll('.player__slider');

// functions

//재생/멈춤 기능
function togglePlay(){
    if(video.paused){
        video.play()
    } else {
        video.pause()
    }
}

//재생/멈춤 아이콘 변경 기능
function updateToggle(){
    if (this.paused) {
        // console.log('play');
        toggle.textContent = '►';
    } else {
        // console.log('pause');
        toggle.textContent = '❚❚';
    }
}

//재생 좌표 버튼으로 이동 기능
function skip(){
    console.log(this.dataset.skip);
    video.currentTime += parseFloat(this.dataset.skip);
}

//비디오 콘트롤 볼륨&재생속도 조절 기능
function handleRangeUpdate(){
    video[this.name]=this.value;
    // console.log(this.value);
    // console.log(this.name);
}

//영상 재생 현황?진도? 보여주기 기능
function handleProgress(){
    const percent = (video.currentTime/video.duration)*100
    // console.log(percent);
    progressBar.style.flexBasis = `${percent}%`;
}

//재생 좌표 이동 기능
function scrub(e){
    const place = (e.offsetX / progress.offsetWidth) * video.duration;
    video.currentTime = place; 
}

//위의 기능들 키보드 조작으로 하기
function keyMove(e){
    if (e.which === 37 && video.currentTime > 10){
        video.currentTime += parseFloat(skipButtons[0].dataset.skip);
    }
    if (e.which === 39 && video.currentTime < 570){
        video.currentTime += parseFloat(skipButtons[1].dataset.skip);
    }
    if (e.which === 32){
        // console.log('space');
        togglePlay();
    }
 
}

function volumeMove(e){
    if(e.which === 38 || e.which === 40){
        ranges[0].focus();
    }
}

// event listners
video.addEventListener("click", togglePlay);
video.addEventListener("play", updateToggle);
video.addEventListener("pause", updateToggle);
video.addEventListener("timeupdate", handleProgress);

toggle.addEventListener("click", togglePlay);
skipButtons.forEach(button=> button.addEventListener("click", skip));
ranges.forEach(range=>range.addEventListener("change", handleRangeUpdate));
ranges.forEach(range=>range.addEventListener("mousemove", handleRangeUpdate));

let mousedown = false;
progress.addEventListener("click", scrub);
progress.addEventListener("mousemove", (e) => mousedown && scrub(e));
progress.addEventListener("mousedown", ()=> mousedown = true);
progress.addEventListener("mouseup", ()=> mousedown = false);

window.addEventListener("keydown", keyMove);
window.addEventListener("keydown", volumeMove);
</script>
</header>
