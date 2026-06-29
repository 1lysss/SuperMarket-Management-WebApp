/* =========================================
   confirm-delete.js — themed modal, reusable

   HOW TO USE:
   1. Place in static/js/confirm-delete.js
   2. Link at the bottom of any page:
        <script src="/js/confirm-delete.js"></script>
   3. Add data-confirm="Your message here" to any delete <button>

   EXAMPLE:
   <button type="submit" data-confirm="Are you sure you want to delete this employee?">
     Delete
   </button>
   ========================================= */

(function () {

  /* ── Inject styles ── */
  const style = document.createElement('style');
  style.textContent = `
    #confirm-overlay {
      display: none;
      position: fixed;
      inset: 0;
      background: rgba(9, 99, 126, 0.18);
      z-index: 9999;
      align-items: center;
      justify-content: center;
    }
    #confirm-overlay.show {
      display: flex;
    }
    #confirm-box {
      background: #ffffff;
      border: 1.5px solid #c4dde3;
      border-radius: 12px;
      padding: 2rem;
      width: 100%;
      max-width: 400px;
      margin: 1rem;
      box-shadow: 0 8px 32px rgba(9, 99, 126, 0.15);
      font-family: 'DM Sans', 'Segoe UI', sans-serif;
    }
    #confirm-box .confirm-icon {
      width: 44px;
      height: 44px;
      background: #fde8e6;
      border-radius: 50%;
      display: flex;
      align-items: center;
      justify-content: center;
      margin-bottom: 1rem;
    }
    #confirm-box .confirm-icon svg {
      width: 20px;
      height: 20px;
      stroke: #c0392b;
    }
    #confirm-box h3 {
      font-family: 'Space Grotesk', 'Segoe UI', sans-serif;
      font-size: 1rem;
      font-weight: 700;
      color: #09637E;
      margin-bottom: 0.4rem;
    }
    #confirm-box p {
      font-size: 0.88rem;
      color: #4a7a86;
      margin-bottom: 1.5rem;
      line-height: 1.55;
    }
    #confirm-box .confirm-actions {
      display: flex;
      gap: 0.6rem;
      justify-content: flex-end;
    }
    #confirm-cancel {
      font-family: 'DM Sans', sans-serif;
      font-size: 0.88rem;
      font-weight: 400;
      padding: 0.45rem 1.1rem;
      border-radius: 7px;
      border: 1.5px solid #c4dde3;
      color: #4a7a86;
      background: transparent;
      cursor: pointer;
      transition: border-color 0.15s, color 0.15s;
    }
    #confirm-cancel:hover {
      border-color: #7AB2B2;
      color: #09637E;
    }
    #confirm-ok {
      font-family: 'DM Sans', sans-serif;
      font-size: 0.88rem;
      font-weight: 500;
      padding: 0.45rem 1.1rem;
      border-radius: 7px;
      border: none;
      background: #c0392b;
      color: #ffffff;
      cursor: pointer;
      transition: background 0.15s;
    }
    #confirm-ok:hover {
      background: #a93226;
    }
  `;
  document.head.appendChild(style);

  /* ── Inject modal HTML ── */
  const overlay = document.createElement('div');
  overlay.id = 'confirm-overlay';
  overlay.innerHTML = `
    <div id="confirm-box">
      <div class="confirm-icon">
        <svg fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round"
                d="M12 9v3.75m9-.75a9 9 0 1 1-18 0 9 9 0 0 1 18 0zm-9 3.75h.008v.008H12v-.008z" />
        </svg>
      </div>
      <h3>Confirm Delete</h3>
      <p id="confirm-message">Are you sure you want to delete this?</p>
      <div class="confirm-actions">
        <button id="confirm-cancel">Cancel</button>
        <button id="confirm-ok">Delete</button>
      </div>
    </div>
  `;
  document.body.appendChild(overlay);

  /* ── Logic ── */
  let pendingForm = null;

  document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('button[data-confirm]').forEach(function (btn) {
      btn.addEventListener('click', function (e) {
        e.preventDefault();
        pendingForm = btn.closest('form');
        document.getElementById('confirm-message').textContent =
          btn.dataset.confirm || 'Are you sure you want to delete this?';
        overlay.classList.add('show');
      });
    });
  });

  document.getElementById('confirm-cancel').addEventListener('click', function () {
    overlay.classList.remove('show');
    pendingForm = null;
  });

  document.getElementById('confirm-ok').addEventListener('click', function () {
    if (pendingForm) pendingForm.submit();
    overlay.classList.remove('show');
  });

  /* close on backdrop click */
  overlay.addEventListener('click', function (e) {
    if (e.target === overlay) {
      overlay.classList.remove('show');
      pendingForm = null;
    }
  });

  /* close on Escape */
  document.addEventListener('keydown', function (e) {
    if (e.key === 'Escape') {
      overlay.classList.remove('show');
      pendingForm = null;
    }
  });

})();
